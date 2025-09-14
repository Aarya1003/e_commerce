import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import HomeCarasoulData from './HomeCarasoulData';

export default function HomeCarasoul() {
     const items=HomeCarasoulData.map((item)=> (<img className='w-[100%] h-[400px] object-cover object-top mx-auto' role='presentation' src={item.image} alt=''/>))
  return (
   <AliceCarousel
        autoPlay
        autoPlayStrategy="none"
        autoPlayInterval={3000}
        animationDuration={3000}
        animationType="fadeout"
        infinite
        touchTracking={false}
        disableButtonsControls
        items={items}
    />
  )
}