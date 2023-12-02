import React from 'react'
import { Grid, Form, Button, Input, Table } from 'semantic-ui-react'
import OrderForm from '../misc/OrderForm'

function OrderTable({ orders, orderDescription, orderTextSearch, handleInputChange, handleCreateOrder, handleDeleteOrder, handleSearchOrder }) {
  let productList
  if (orders.length === 0) {
    productList = (
      <Table.Row key='no-order'>
        <Table.Cell collapsing textAlign='center' colSpan='5'>No Product</Table.Cell>
      </Table.Row>
    )
  } else {
    productList = orders.map(order => {
      return (
        <Table.Row key={order.id}>
          <Table.Cell collapsing>
            <Button
              circular
              color='red'
              size='small'
              icon='trash'
              onClick={() => handleDeleteOrder(order.id)}
            />
          </Table.Cell>
          <Table.Cell>{order.id}</Table.Cell>
          <Table.Cell>{order.name}</Table.Cell>
          <Table.Cell>{order.increment}</Table.Cell>
          <Table.Cell>{order.description}</Table.Cell>
        </Table.Row>
      )
    })
  }

  return (
    <>
      <Grid stackable divided>
        <Grid.Row columns='2'>
          <Grid.Column width='5'>
            <Form onSubmit={handleSearchOrder}>
              <Input
                action={{ icon: 'search' }}
                name='orderTextSearch'
                placeholder='Search by Name or Description'
                value={orderTextSearch}
                onChange={handleInputChange}
              />
            </Form>
          </Grid.Column>
          <Grid.Column>
            <OrderForm
              orderDescription={orderDescription}
              handleInputChange={handleInputChange}
              handleCreateOrder={handleCreateOrder}
            />
          </Grid.Column>
        </Grid.Row>
      </Grid>
      <Table compact striped selectable>
        <Table.Header>
          <Table.Row>
            <Table.HeaderCell width={1} />
            <Table.HeaderCell width={2}>Product Name</Table.HeaderCell>
            <Table.HeaderCell width={4}>Description</Table.HeaderCell>
            <Table.HeaderCell width={3}>Initial Price</Table.HeaderCell>
            <Table.HeaderCell width={4}>Created At</Table.HeaderCell>
          </Table.Row>
        </Table.Header>
        <Table.Body>
          {productList}
        </Table.Body>
      </Table>
    </>
  )
}

export default OrderTable