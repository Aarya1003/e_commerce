import React from 'react';
import Grid from '@mui/material/Grid';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import AddressCard from '../AddressCard/AddressCard';

const DeliveryAddForm = () => {

    const handleSubmit = (e) => {
        e.preventDefault();  // ✅ Prevent page reload

        const data = new FormData(e.currentTarget);  // ✅ Get data from form

        const address = {
            firstName: data.get("firstName"),
            lastName: data.get("lastName"),
            address: data.get("address"),
            city: data.get("city"),
            state: data.get("state"),
            zip: data.get("zip"),
            number: data.get("number")
        };

        console.log("Address submitted:", address);  // ✅ Log or process the data
    };

    return (
        <div className='flex flex-align'>
            <Grid container spacing={4} className='w-[30rem]'>
                <Grid item xs={12} lg={5} className="border rounded-e-md shadow-md h-[30.5rem] w-[30rem] overflow-y-scroll">
                    <div className="p-5 py-7 border-b cursor-pointer">
                        <AddressCard />
                        <Button
                            sx={{ mt: 2, bgcolor: "RGB(145 85 253)" }}
                            size="large"
                            variant="contained">
                            Deliver Here
                        </Button>
                    </div>
                </Grid>
            </Grid>

            <Grid item xs={12} lg={7} className='ml-20 w-[50rem]'>
                <Box className="border rounded-s-md shadow-md p-5">
                    <form onSubmit={handleSubmit}>  {/* ✅ Attach submit handler here */}
                        <Grid container spacing={3}>
                            <Grid item xs={12} sm={6} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="firstName"
                                    name="firstName"
                                    label="First Name"
                                    fullWidth
                                    autoComplete="given-name"
                                />
                            </Grid>
                            <Grid item xs={12} sm={6} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="lastName"
                                    name="lastName"
                                    label="Last Name"
                                    fullWidth
                                    autoComplete="given-name"
                                />
                            </Grid>
                            <Grid item xs={12} className='w-[50rem]'>
                                <TextField
                                    required
                                    id="address"
                                    name="address"
                                    label="Address"
                                    fullWidth
                                    autoComplete="given-name"
                                    multiline
                                    rows={4}
                                />
                            </Grid>
                            <Grid item xs={12} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="city"
                                    name="city"
                                    label="City"
                                    fullWidth
                                    autoComplete="given-name"
                                />
                            </Grid>
                            <Grid item xs={12} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="state"
                                    name="state"
                                    label="State"
                                    fullWidth
                                    autoComplete="given-name"
                                />
                            </Grid>
                            <Grid item xs={12} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="zip"
                                    name="zip"
                                    label="Zip / Postal code"
                                    fullWidth
                                    autoComplete="shipping postal-code"
                                />
                            </Grid>
                            <Grid item xs={12} className='w-[22.5rem]'>
                                <TextField
                                    required
                                    id="number"
                                    name="number"
                                    label="Mobile Number"
                                    fullWidth
                                    autoComplete="given-name"
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <Button
                                    sx={{ mt: 2, bgcolor: "RGB(145 85 253)" }}
                                    size="large"
                                    variant="contained"
                                    type="submit"  // ✅ Type submit triggers form submission
                                >
                                    Deliver Here
                                </Button>
                            </Grid>
                        </Grid>
                    </form>
                </Box>
            </Grid>
        </div>
    );
};

export default DeliveryAddForm;
