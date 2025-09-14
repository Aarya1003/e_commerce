import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Avatar from '@mui/material/Avatar';
import Rating from '@mui/material/Rating';

const ProductReviewCard = () => {
  return (
    <div className='text-left'>
      <Grid container spacing={2} gap={3}>
        <div>
          <Grid item xs={1}>
            <Box>
              <Avatar className="text-white" sx={{ width: 56, height: 56, bgcolor: "#9155fd" }}>
                R
              </Avatar>
            </Box>
          </Grid>

          <Grid item xs={9}>
            <div className="space-y-2">
              <div>
                <p className="font-semibold text-lg">Ram</p>
                <p className="opacity-75">April 5, 2023</p>
              </div>
            </div>
            <Rating value={4.5} readOnly precision={0.5} name="half-rating" className='text-left'/>
            <p className='text-left'>Nice shirt. I loved it.</p>
          </Grid>
        </div>
      </Grid>
    </div >
  );
}

export default ProductReviewCard;
