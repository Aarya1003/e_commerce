import React from 'react';
import Grid from '@mui/material/Grid';
import AdjustIcon from '@mui/icons-material/Adjust';
import OrderCard from './OrderCard';

const orderStatus = [
    { label: 'On The Way', value: 'on_the_way' },
    { label: 'Delivered', value: 'delivered' },
    { label: 'Cancelled', value: 'cancelled' },
    { label: 'Returned', value: 'returned' },
];

export default function Order(){
    return (
        <div>
            <Grid container  className=" h-screen bg-gray-100 hover:shadow-2xl shadow-lg p-5">
                {/* Sidebar */}
                <Grid item xs={3} className='w-[20rem]'>
                    <div className="bg-white p-6 sticky top-0">
                        <h1 className="font-bold text-lg">Filters</h1>
                        <h2 className="font-semibold mt-6 mb-2">ORDER STATUS</h2>
                        <div className="space-y-4">
                            {orderStatus.map((option) => (
                                <div key={option.value} className="flex items-center">
                                    <input
                                        defaultValue={option.value}
                                        type="checkbox"
                                        className="h-4 w-4 border-gray-300 text-indigo-600 focus:ring-indigo-500"
                                    />
                                    <label className="ml-3 text-gray-600" htmlFor={option.value}>
                                        {option.label}
                                    </label>
                                </div>
                            ))}
                        </div>
                    </div>
                </Grid>

                {/* Main Content */}
                <Grid item xs={9} sx={{ height: '100%', overflowY: 'auto' }}>
                    <div className="ml-10 space-y-4">
                        <OrderCard />
                        <OrderCard />
                        <OrderCard />
                        {/* Add more OrderCard components as needed */}
                    </div>
                </Grid>
            </Grid>
        </div>
    );
};