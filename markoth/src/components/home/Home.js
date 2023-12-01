import React, { useEffect, useState } from 'react'
import { Statistic, Icon, Grid, Container, Image, Segment, Dimmer, Loader } from 'semantic-ui-react'
import { orderApi } from '../misc/OrderApi'
import { handleLogError } from '../misc/Helpers'
import './Home.css';

function Home() {
  const [numberOfUsers, setNumberOfUsers] = useState(0)
  const [numberOfOrders, setNumberOfOrders] = useState(0)
  const [isLoading, setIsLoading] = useState(true)

  useEffect(() => {
    async function fetchData() {
      try {
        const responseUsers = await orderApi.numberOfUsers()
        const numberOfUsers = responseUsers.data

        const responseOrders = await orderApi.numberOfOrders()
        const numberOfOrders = responseOrders.data

        setNumberOfUsers(numberOfUsers)
        setNumberOfOrders(numberOfOrders)
      } catch (error) {
        handleLogError(error)
      } finally {
        setIsLoading(false)
      }
    }

    fetchData()
  }, [])

  if (isLoading) {
    return (
      <Segment basic style={{ marginTop: window.innerHeight / 2 }}>
        <Dimmer active inverted>
          <Loader inverted size='huge'>Loading</Loader>
        </Dimmer>
      </Segment>
    )
  }

  return (
        <div>
            <div className="bgimg"></div>
            <div className="maintxt">
                <div className="welcome">WELCOME</div>
                <div className="description">Have a happy bidding!</div>
            </div>
        </div>
  )
}

export default Home