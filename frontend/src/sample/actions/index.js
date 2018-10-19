// Actions are payloads of information that send data from your application to your store. 
// They are the only source of information for the store. You send them to the store using 
// store.dispatch().

/*
 * action types
 */
export const ADD_TODO = 'ADD_TODO'
export const TOGGLE_TODO = 'TOGGLE_TODO'
export const SET_VISIBILITY_FILTER = 'SET_VISIBILITY_FILTER'

/*
 * other constants
 */
export const VisibilityFilters = {
    SHOW_ALL: 'SHOW_ALL',
    SHOW_COMPLETED: 'SHOW_COMPLETED',
    SHOW_ACTIVE: 'SHOW_ACTIVE'
}

/*
 * action creators
 */
let id = 0;
export const addTodo = (text) => ({
    type: ADD_TODO,
    text,
    id: id++
})

export const toggleTodo = (index) => ({
    type: TOGGLE_TODO,
    index
})

export const setVisibilityFilter = (filter) => ({
    type: SET_VISIBILITY_FILTER,
    filter
})
