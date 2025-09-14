import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";
import AliceCarousel from 'react-alice-carousel';
import 'react-alice-carousel/lib/alice-carousel.css';
import KeyboardArrowLeftIcon from '@mui/icons-material/KeyboardArrowLeft';
import Button from '@mui/material/Button';
import { useRef, useState } from "react";

export default function HomeSectionCarasoul({data,sectionName}) {

  const carasoulRef=useRef(null);
  const [activeIndex, setActiveIndex] = useState(0);
  const responsive = {
    0: { items: 1 },
    720: { items: 4 },
    1024: { items: 5 },
  };

  const items = data.slice(0,10).map((item) => <HomeSectionCard product={item}/>)

const setPrev = () => carasoulRef.current.slidePrev();
  const setNext = () => carasoulRef.current.slideNext();
    
  const syncActiveIndex = ({ item }) => setActiveIndex(item);

  return (
    <div className="px-4 lg:px-8">
      <h2 className="text-2xl font-extrabold text-gray-800 py-2">{sectionName}</h2>
      <div className="relative p-5">
        <AliceCarousel
           ref={carasoulRef}
          disableButtonsControls
          disableDotsControls
          items={items}
          responsive={responsive}
          slideToIndex={activeIndex}
          onSlideChanged={syncActiveIndex}
        />

        {activeIndex!==items.length-5 && (<Button variant="contained" className="z-50"
        onClick={setNext} 
        sx={{
          position: 'absolute', top: "8rem", right: "0rem",
          transform: "translateX(50%) rotate(90deg)"
        }}
          aria-label="next">
          <KeyboardArrowLeftIcon sx={{ transform: "rotate(90deg)" }} />
        </Button>)}

        {activeIndex!==0 && (<Button variant="contained" className="z-50"
        onClick={setPrev}
        sx={{
          position: 'absolute', top: "8rem", left: "0rem",
          transform: "translateX(-50%) rotate(-90deg)"
        }}
          aria-label="next">
          <KeyboardArrowLeftIcon sx={{ transform: "rotate(90deg)" }} />
        </Button>)}
      </div>
    </div>
  )
}
