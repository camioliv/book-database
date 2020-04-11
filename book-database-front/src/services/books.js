import {http} from './config'

export default{
    list:() => {
        return http.get('books')
    },
    save:(book) =>{
        return http.post('book', book)
    }, 
    listByISBN:(isbn) => {
        return http.get('book/'+isbn)
    }
}