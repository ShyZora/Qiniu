<template>
    <allNeed :urlarr="urlarr"></allNeed>
</template>

<script>
var axios = require('axios');
import allNeed from './allNeed.vue'
export default {
    name: 'mainPage',
    data() {
        return {
            urlarr:[],
        }
    },
    components: {
        allNeed
    },
    methods: {
        getVideo() {
            let that=this
            axios({
                method: 'get',
                url: 'api/home/getCategoryTagList?id=7',
            }).then(function (response) {
                that.urlarr=response.data.data
            })
                .catch(function (error) {
                    console.log(error);
                });
        },
        
    },
    mounted() {
        this.getVideo()
    }
}
</script>
<style scoped>
</style>