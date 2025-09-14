import IconButton from '@mui/material/IconButton';
import Button from '@mui/material/Button';
import RemoveCircleOutlineIcon from '@mui/icons-material/RemoveCircleOutline';
import AddCircleOutlineIcon from '@mui/icons-material/AddCircleOutline';


const CartItem = () => {
    return (
        <div>
            <div className='p-5 rounded shadow-lg roumded-md'>
                <div className='flex items-center border solid-black-border'>

                    <div className='w-[5rem] h-[5rem] lg:w-[9rem] lg:h-[9rem]'>
                        <img className="ww-full h-full object-cover object-top" src="https://tiimg.tistatic.com/fp/1/007/463/plain-and-stretchable-small-to-xxl-size-denim-female-jeans-for-casual-wear-008.jpg" alt="" />
                    </div>
                    <div className='ml-5 space-y-1'>
                        <p className='font-semibold text-lg'>Light Blue plain and stretchable Jeans</p>
                        <p className='opacity-70 text-left text-lg'>Size : L</p>
                        <p className='opacity-70 mt-2 text-left text-lg'>Seller : TrueFashion</p>
                        <div className="flex space-x-5 items-center text-gray-900 mt-6 ml-50">
                            <p className="font-semibold">₹199</p>
                            <p className="opacity-50 line-through">₹211</p>
                            <p className="text-green-600 font-semibold">5% Off</p>
                        </div>
                    </div>
                </div>
<div className='lg: flex items-center 1g:space-x-10 pt-4'>
<div className='flex items-center space-x-2'>
<IconButton >
<RemoveCircleOutlineIcon/>
</IconButton>
<span className='py-1 px-7 border rounded-sm'>3</span>
<IconButton sx={{color:"RGB(145 85 253)"}}>
<AddCircleOutlineIcon/>
</IconButton>
</div>
<div>
<Button sx={{color: "RGB(145 85 253)"}} >remove</Button>
</div>
</div>


            </div>
        </div>
    )
}

export default CartItem;
