<template>
    <div>

        <upVideo />

    </div>
</template>

<script>
import upVideo from '../components/upVideo.vue'
export default {
    name: 'home',
    data() {
        return {
            input: "",
            dialogVisible: false
        }
    },
    components: {
        upVideo
    },
    methods: {

    }
    // handleCommand(command){
    //     if(command=='a'){
    //         Cookie.remove('token')
    //         this.$router.push('/login')
    //     }


    // }
}
</script>
<style lang="less" scoped>

</style>