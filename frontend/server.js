const jsonServer = require('json-server')
const faker = require('faker');
const _ = require('lodash');

const generateData = () => {
    /* Sample user data
    {
          "username":"cimela",
          "firstName":"Quyen",
          "lastName":"Quyen",
          "email":"quyen.it1423@gmail.com"
    }
    */
    return {
        users: _.times(10, () => ({
            username: faker.internet.userName(),
            firstName: faker.name.firstName(),
            lastName: faker.name.lastName(),
            email: faker.internet.email()
        }))
    }
}
const server = jsonServer.create()
const router = jsonServer.router(generateData())
const middlewares = jsonServer.defaults()
const FAKE_SERVER_PORT = 3000

server.use(middlewares)
router.render = (req, res) => {
    res.jsonp({
        total: res.locals.data.length,
        data: res.locals.data
    })
}
server.use('/api', router)
server.listen(FAKE_SERVER_PORT, () => console.log('Fake JSON Server is running'))
