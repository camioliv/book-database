import {http} from './config'

export default{
    list:(name) => {
        if (name) {
            return http.get('locations?name=' + name);
        } else {
            return http.get('locations');
        }
    }    
}