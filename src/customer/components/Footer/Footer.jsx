import { Button } from '@headlessui/react';
import Grid from '@mui/material/Grid'
import Typography from '@mui/material/Typography';


const Footer = () => {
  return (
    <div style={{ width: "100hw" }}>
      <Grid className='bg-black text-white text-center mt-10'
      container
      sx={{bgcolor:"black", color:"white",py:3,px:2,width: "100%",
          maxWidth: "100%"}}>
        <Grid item xs={12} sm={6} md={3} sx={{marginLeft:"80px", marginRight:"160px"}}>
          <Typography className='pb-5' variant='h6'>Company</Typography>
         <div><Button className='pb-5' variant='h6' gutterBottom>About</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Blog</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Press</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Jobs</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Partners</Button></div> 
        </Grid>

        <Grid item xs={12} sm={6} md={3} sx={{marginLeft:"160px", marginRight:"160px"}}>
          <Typography className='pb-5' variant='h6'>Solutions</Typography>
         <div><Button className='pb-5' variant='h6' gutterBottom>Marketing</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Analytics</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Commerce</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Insights</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Supports</Button></div> 
        </Grid>

        <Grid item xs={12} sm={6} md={3} sx={{marginLeft:"160px", marginRight:"160px"}}>
          <Typography className='pb-5' variant='h6'>Documentation</Typography>
         <div><Button className='pb-5' variant='h6' gutterBottom>Guides</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>API Status</Button></div> 
        </Grid>

        <Grid item xs={12} sm={6} md={3} sx={{marginLeft:"160px", marginRight:"80px"}}>
          <Typography className='pb-5' variant='h6'>Legal</Typography>
         <div><Button className='pb-5' variant='h6' gutterBottom>Claim</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Privacy</Button></div> 
          <div><Button className='pb-5' variant='h6' gutterBottom>Term</Button></div> 
        </Grid>

        <Grid className='pt-20' item xs={12} sx={{marginLeft:"600px"}}>
          <Typography variant='body2' component='p' align='center'>
              &copy; 2025 Sandhya's Land. All rights reserved
          </Typography>
          <Typography variant='body2' component='p' align='center'>
              Made with Love
          </Typography>
        </Grid>
      </Grid>
    </div>
  )
}

export default Footer
