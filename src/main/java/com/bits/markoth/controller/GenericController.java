package com.bits.markoth.controller;

import com.bits.markoth.exception.MarkothException;
import com.bits.markoth.service.GenericService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStream;
import java.util.List;

@RestController
@Slf4j
abstract class GenericController<E, ID> {

    protected final GenericService<E, ID> service;

    GenericController(final GenericService<E, ID> service) {
        this.service = service;
    }

    @GetMapping
    public List<E> list() {
        final List<E> l = this.service.findAllAsList();
        return l;
    }

    @GetMapping(value = "/pageable", produces = "application/json")
    @ResponseBody
    public Page<E> getPage(@PageableDefault(size = Integer.MAX_VALUE) final Pageable pageable) {
        return this.service.findPage(pageable);
    }

    @PostMapping
    public E create(@RequestBody final E entity) {
        return service.create(entity);
    }

    @PutMapping(value = "{id}")
    public E update(@PathVariable(value = "id") final Long id,
                    @RequestBody final E entity) {
        return service.update((ID) id, entity);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") final Long id) {
        service.delete((ID) id);
    }

    @GetMapping(value = "{id}", produces = "application/json")
    public E get(@PathVariable(value = "id") final Long id) {
        return service.findById((ID) id);
    }

    public void addFileToResponse(final HttpServletResponse response,
                                  final String fileName, final byte[] content) {
        try {
            response.setContentType("application/force-download");
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-disposition", "attachment;filename=${fileName}");
            final OutputStream os = response.getOutputStream();
            os.write(content);
            os.close();
        } catch (Exception e) {
            throw new MarkothException(e.getMessage());
        }
    }

}