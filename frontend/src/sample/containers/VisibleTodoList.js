import { connect } from 'react-redux'
import TodoList from '../components/TodoList'
import { VisibilityFilters, toggleTodo } from '../actions'

const getVisibleTodos = (todos, filter) => {
    switch (filter) {
        case VisibilityFilters.SHOW_COMPLETED:
            return todos.filter(t => t.completed)

        case VisibilityFilters.SHOW_ACTIVE:
            return todos.filter(t => !t.completed)

        case VisibilityFilters.SHOW_ALL:
        default:
            return todos
    }
}

const mapStateToProps = state => ({
    todos: getVisibleTodos(state.todos, state.visibilityFilter)
})

const mapDispatchToProps = dispatch => ({
    onTodoClick: id => {
        dispatch(toggleTodo(id))
    }
})

const VisibleTodoList = connect(
    mapStateToProps,
    mapDispatchToProps
)(TodoList)

export default VisibleTodoList