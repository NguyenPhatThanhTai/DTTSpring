document.querySelectorAll('.product-img-item').forEach(e => {
    e.addEventListener('click', () => {
        let img = e.querySelector('img').getAttribute('src')
        document.querySelector('#product-img > img').setAttribute('src', img)
    })
})

document.querySelector('#view-all-description').addEventListener('click', () => {
    let content = document.querySelector('.product-detail-description-content')
    content.classList.toggle('active')
    document.querySelector('#view-all-description').innerHTML = content.classList.contains('active') ? 'view less' : 'view all'
})

let products = [
    {
        name: 'BAG KEY PURPLE',
        image1: './images/bag1.jpg',
        image2: './images/bag1_hover.jpg',
        old_price: '300.000 VND',
        curr_price: '299.000 VND'
    },
    {
        name: 'BAG JR BLACK',
        image1: './images/bag2.jpg',
        image2: './images/bag2_hover.jpg',
        old_price: '400.000 VND',
        curr_price: '300.000 VND'
    },
    {
        name: 'BAG TUNE BLUE OCEAN',
        image1: './images/bag3.jpg',
        image2: './images/bag3_hover.jpg',
        old_price: '400.000 VND',
        curr_price: '300.000 VND'
    },
    {
        name: 'BAG BLUE HORIZON',
        image1: './images/bag4.jpg',
        image2: './images/bag4_hover.jpg',
        old_price: '400.000 VND',
        curr_price: '300.000 VND'
    },
    {
        name: 'BAG CAROL BLACK',
        image1: './images/bag5.jpg',
        image2: './images/bag5_hover.jpg',
        old_price: '400.000 VND',
        curr_price: '300.000 VND'
    },
    {
        name: 'BAG CAROL PINK',
        image1: './images/bag6.jpg',
        image2: './images/bag6_hover.jpg',
        old_price: '400.000 VND',
        curr_price: '300.000 VND'
    }
]

let product_list = document.querySelector('#related-products')

renderProducts = (products) => {
    products.forEach(e => {
        let prod = `
            <div class="col-4 col-md-6 col-sm-12">
                <div class="product-card">
                    <div class="product-card-img">
                        <img src="${e.image1}" alt="">
                        <img src="${e.image2}" alt="">
                    </div>
                    <div class="product-card-info">
                        <div class="product-btn">
                            <a href="./product-detail.html" class="btn-flat btn-hover btn-shop-now">shop now</a>
                            <button class="btn-flat btn-hover btn-cart-add">
                                <i class='bx bxs-cart-add'></i>
                            </button>
                            <button class="btn-flat btn-hover btn-cart-add">
                                <i class='bx bxs-heart'></i>
                            </button>
                        </div>
                        <div class="product-card-name">
                            ${e.name}
                        </div>
                        <div class="product-card-price">
                            <span><del>${e.old_price}</del></span>
                            <span class="curr-price">${e.curr_price}</span>
                        </div>
                    </div>
                </div>
            </div>
        `
        product_list.insertAdjacentHTML("beforeend", prod)
    })
}

renderProducts(products)