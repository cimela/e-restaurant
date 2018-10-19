import { createStore } from 'redux'
import todoApp from '../reducers'

export const store = createStore(
    todoApp,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__() // For Redux Chrome extension: https://github.com/zalmoxisus/redux-devtools-extension#usage
)