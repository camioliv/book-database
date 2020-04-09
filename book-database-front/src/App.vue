<template>
  <v-app class="grey lighten-4">
    <Navbar/>
    <SearchBar/>
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar'
import SearchBar from '@/components/SearchBar'
export default {
  name: 'App',
  components: {Navbar, SearchBar},
  data: () => ({
    //
  }),
};
</script>
