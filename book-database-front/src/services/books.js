import {http} from './config'
import {httpIsbn} from './isbndbConfig'

export default{
    list:() => {
        return http.get('books')
    },
    save:(book) =>{
        return http.post('book', book)
    }, 
    listByISBN:(isbn) => {
        return http.get('book/'+isbn)
    },
    extSearchISBN:(isbn)=> {
        return httpIsbn.get('book/'+isbn)
    },
}