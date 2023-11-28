package com.bits.markoth.service;

import com.bits.markoth.exception.MarkothException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;

import java.util.List;


@Slf4j
public abstract class GenericService<E, ID> {
    protected final JpaRepository<E, ID> repository;

    GenericService(final JpaRepository<E, ID> repository) {
        this.repository = repository;
    }

    public E create(final E entity) {
        if (log.isDebugEnabled()) {
            log.info("Creating " + entity.getClass().getSimpleName() +
                    ", Entity:" + entity.toString());
        }
        final E e = save(entity);
        if (log.isDebugEnabled()) {
            log.debug("Created " + e.getClass().getSimpleName() + ",Entity:" + e.toString());
        }
        return e;
    }

    public E retrieve(final ID id) {
        //Validate.notNull(id, ""id" cannot be null")
        final E e = repository.findById(id).get();
        log.debug("Retrieved " + e.getClass().getSimpleName() + ",Entity:" + e.toString());
        return e;
    }

    public E update(final ID id, final E newEntity) {
        if (log.isDebugEnabled()) {
            log.debug("Updating " +
                    newEntity.getClass().getSimpleName() + ",Entity:" +
                    newEntity.toString());
        }
        //Validate.notNull(id, ""id" cannot be null")
        //Validate.notNull(newEntity, ""newEntity" cannot be null")
        final E entity = retrieve(id);
        if (entity != null) {
            updateEntity(entity, newEntity);
            final E e = save(entity);
            if (log.isDebugEnabled()) {
                log.debug("Updated " + e.getClass().getSimpleName() +
                        ", Entity:" + e.toString());
            }
            return e;
        } else {
            throw new MarkothException("Could not find entity to update. id:" + id + "," +
                    " entity:" + newEntity.getClass().getName());
        }
    }

    protected void updateEntity(final E oldEntity, final E newEntity) {
    }

    //This is implemented in product based controller
    public Page<E> findPageByProduct(final Long productId,
                                     @PageableDefault(size = Integer.MAX_VALUE) final Pageable pageable) {
        throw new MarkothException("Not implemented.");
    }

    private E save(final E entity) {
        final E e = repository.save(entity);
        return e;
    }

    public E findById(final ID id) {
        final E e = repository.findById(id).get();
        if (log.isDebugEnabled()) {
            log.debug("Retrieved " + e.getClass().getSimpleName() + ",Entity:" + e.toString());
        }
        return e;
    }

    public void delete(final ID id) {
        final E e = repository.findById(id).get();
        if (e != null) {
            repository.delete(e);
        }
    }

    public Page<E> findPage(@PageableDefault(size = Integer.MAX_VALUE) final Pageable pageable) {
        final Page<E> page = repository.findAll(pageable);
        if (log.isDebugEnabled()) {
            page.forEach(it -> {
                log.debug("Retrieved " + it.getClass().getSimpleName()
                        + ", Entity:" + it.toString());
            });
        }
        return page;
    }

    public List<E> findAllAsList() {
        final List<E> l = repository.findAll();
        if (log.isDebugEnabled()) {
            l.forEach(it -> {
                log.debug("Retrieved " + it.getClass().getSimpleName()
                        + ", Entity:" + it.toString());
            });
        }
        return l;
    }

    public List<E> retrieve(List<ID> ids) {
        return Lists.newArrayList(repository.findAllById(ids));
    }
}