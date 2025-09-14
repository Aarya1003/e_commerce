import Grid from '@mui/material/Grid';
import AdjustIcon from '@mui/icons-material/Adjust';
import { useNavigate } from 'react-router-dom';

const OrderCard = () => {

    const navigate=useNavigate();

    return (
         <div onClick={()=>navigate(`/account/order/${5}`)} className="bg-white p-4 rounded-md shadow-md">
            <Grid container alignItems="center" spacing={32}>
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
                <Grid item xs={2}>
                    <p className="text-sm font-semibold">₹1999</p>
                </Grid>
                <Grid item xs={4}>
                    <div className="ml-4 mr-5">
                        <p className="flex items-center text-green-600 text-sm font-semibold">
                            <AdjustIcon sx={{ width: 15, height: 15, marginRight: '5px' }} />
                            Delivered on March 03
                        </p>
                        <p className="text-xs text-gray-500">Your item has been delivered</p>
                    </div>
                </Grid>
            </Grid>
        </div>
    )
}

export default OrderCard
