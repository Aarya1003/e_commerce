import AddressCard from '../AddressCard/AddressCard'
import CartItem from '../Cart/CartItem'
import Button from '@mui/material/Button';

const OrderSummary = () => {
  return (
    <div>
      <div className='p-5 shadow-lg rounded-s-md border'>
        <AddressCard />
      </div>
      <div>
        <div className='lg:grid grid-cols-3 lg:px-16 relative '>
          <div className='col-span-2'>
            {[1, 1, 1, 1].map((item) => <CartItem />)}
          </div>
          <div className='px-5 sticky top-0 h-[100vh] mt-5 lg:mt-0'>
            <div className="border p-5">
              <p className='uppercase font-bold opacity-60 pb-4'>Price details</p>
              <hr />
              <div className='space-y-3 font-semibold mb-10'>
                <div className='flex justify-between pt-3 text-black'>
                  <span>Price</span>
                  <span>₹4697</span>
                </div>
                <div className='flex justify-between pt-3 text-black'>
                  <span>Discount</span>
                  <span className='text-green-600'>-₹3419</span>
                </div>
                <div className='flex justify-between pt-3 text-black'>
                  <span>Delivery charges</span>
                  <span>Free</span>
                </ div>
                <div className='flex justify-between pt-3 text-black'>
                  <span>Total Amount</span>
                  <span>₹1278</span>
                </ div>

              </div>
              <Button variant='contained' className='w-full mt-10' sx={{ px: '2.5rem', py: '0.7rem', bgcolor: '#9155fd' }}>
                Checkout
              </Button>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default OrderSummary
