<template>
  <div>
    <p>sp</p>
  </div>
</template>

<script>
export default {
    name:'SpGuanli',
    mounted() {
      this.$store.dispatch('getallcom')
    },
}
</script>

<style>

</style>