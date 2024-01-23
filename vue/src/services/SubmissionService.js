import axios from 'axios';

export default {

    save(user, module, submission) {
        return axios.post(`/submission/${user}/${module}`, submission)
    }

}