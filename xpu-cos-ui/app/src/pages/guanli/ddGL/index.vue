<template>
    <div>
        <p>dd</p>
    </div>
</template>

<script>
export default {
        name:'DdGuanli',
        mounted() {
            this.$store.dispatch('getallorder');
        },
}
</script>

<style>

</style>