export default function HomeSectionCard({product}) {
  return (
    <div className="cursor-pointer flex flex-col items-center bg-white rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3
     border border-black m-6">
        <div className="h-[9rem] w-[6rem]">
     <img src={product.imageUrl} alt="" />
        </div>
        <div className="p-4">
          <h3 className="text-lg font-medium text-gray-900">{product.title}</h3>
          <p className="mt-s text-sm text-gray-500">{product.title}{product.color}</p>
        </div>
    </div>
    
  )
}
 