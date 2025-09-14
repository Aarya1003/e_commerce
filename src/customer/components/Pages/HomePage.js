import { mens_kurta } from '../Data/Mens_kurta'
import HomeCarasoul from '../Home/HomeCarasoul'
import HomeSectionCarasoul from '../HomeSectionCarasoul/HomeSectionCarasoul'

export default function HomePage() {
  return (
    <div>
      <HomeCarasoul/>
      <div className='space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10'>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Men's Kurtas"}/>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Women's Dress"}/>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Men's Shirts"}/>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Women's Tops"}/>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Men's Jeans"}/>
        <HomeSectionCarasoul data={mens_kurta} sectionName={"Women's Jeans"}/>
      </div>
    </div>
  )
}
