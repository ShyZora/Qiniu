<template>
    <div class="header">
        <search style="padding: 10px 15px;"/>

    </div>
    
</template>

<script>
import search from "./search.vue"
export default {
    name: 'home',
    data() {
        return {
        }
    },
    components:{
        search
    },
    methods: {

    },
    mounted() {

    },
    computed: {

    }
}
</script>
<style lang="less" scoped>
.header {
    position: absolute;
    height: 60px;
    width: 90%;
    z-index: 10;
    justify-content: space-between;
    align-items: center;
    padding: 0;
}
</style>