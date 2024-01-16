import axios from 'axios';

export default {

    chat(prompt) {
        return axios.get('/GPT/chat', {
            params: {
                prompt: prompt,
            },
        });
    },

}