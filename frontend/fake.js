const faker = require('faker');
const casual = require('casual');

const ORDER_STATUS = ['IN_PROGRESS', 'DELIVERED', 'PARTIALLY_DELIVERED'];


const data = {
    userProfile: [],
    products: [],
    orders: [],
    brands: [
        {key: 1, name: 'Amway', brandImage: "https://logos-download.com/wp-content/uploads/2016/03/Amway_logo_1.png"},
        {key: 2, name: 'Tupperware', brandImage: "https://www.freepnglogos.com/uploads/tupperware-png-logo/tupperware-transparent-png-logo-2.png"},
        {key: 3, name: 'Oriflame', brandImage: "https://miro.medium.com/max/1034/1*rKVCSh89sQyKcw4e_aSWbw.png"},
    ]
};


generateOrder = () => {
    const order = {
        id: casual.integer(from = 0, to = 10000),
        status: casual.random_element(ORDER_STATUS)
    };

    return order
    // }
};

generateOrders = () => {
    for (let i = 0; i < 1000; i++) {
        data.orders.push(generateOrder());
    }
};
// generateUser = () => {
//     casual.define('user', function() {
//         return {
//             email: casual.email,
//             firstname: casual.first_name,
//             lastname: casual.last_name,
//             password: casual.password
//         };
//     });
//
// };

generateUsers = () => {
    // Create 1000 users
    for (let i = 0; i < 1000; i++) {
        const randomFirstName = faker.name.firstName(); // Rowan Nikolaus
        const randomLastName = faker.name.lastName(); // Rowan Nikolaus
        const randomEmail = faker.internet.email(); // Kassandra.Haley@erich.biz
        const randomImageUrl = faker.image.imageUrl(); //

        const format = '+(91)-###-###-####';
        const randomPhoneNumber = casual.numerify(format);

        data.userProfile.push({
            id: i,
            firstName: randomFirstName,
            lastName: randomLastName,
            email: randomEmail,
            phone: randomPhoneNumber,
            imageUrl: randomImageUrl
        })
    }
};

generateProducts = () => {
    for (let i = 0; i < 1000; i++) {
        const name = faker.commerce.productName(); // Rowan Nikolaus
        const material = faker.commerce.productMaterial(); // Rowan Nikolaus
        // const desc = faker.commerce.productDescription(); // Rowan Nikolaus

        data.products.push({
            id: i,
            name: name,
            material: material,
            // description: desc
        })
    }
};

// index.js
module.exports = () => {
    generateUsers();
    generateProducts();
    generateOrders();
    return data
};



// CurrentLocation

nearby: {

}
