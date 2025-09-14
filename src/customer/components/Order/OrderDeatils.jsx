import React from 'react'
import AddressCard from '../AddressCard/AddressCard'
import OrderTracker from './OrderTracker'
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import { deepPurple } from '@mui/material/colors';
import StarBorderIcon from '@mui/icons-material/StarBorder';

const OrderDeatils = () => {
  return (
    <div>
      <div className='px-5 lg:px-20'>
        <h1 className='font-bold text-lg py-10'>Delivery Address</h1>
        <AddressCard />
      </div>

      <div className='py-20'>
        <OrderTracker activeStep={3} />
      </div>

      <Grid container className="space-y-5">
        {[1, 1, 1, 1, 1].map((item) => <Grid item container className="shadow-xl rounded-md p-5 border ml-40" sx={{ alignItems: "center", justifyContent: "space-between" }}>

          <Grid item xs={6}>
            <div className="flex items-center">
              <img
                src="https://c1.staticflickr.com/8/7213/7188482299_8da9da1cb6.jpg"
                alt="Product"
                className="w-20 h-20 object-cover rounded-md"
              />
              <div className="ml-4">
                <p className="text-sm font-semibold">Men Slim Mid Rise Brown Kurta</p>
                <p className="text-xs text-gray-500">Size: M</p>
                <p className="text-xs text-gray-500">Color: Black</p>
              </div>
            </div>
          </Grid>

          <Grid item className='px-5 lg:px-20 ml-80'>
            <Box sx={{ color: deepPurple[500] }}>
              <StarBorderIcon sx={{ fontSize: 4 }} fontSize={"2rem"} className="px-2 " />
              <span>Rate & Review Product</span>
            </Box>
          </Grid>


        </Grid>)}
      </Grid>
    </div>
  )
}

export default OrderDeatils
