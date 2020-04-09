<template>
  <v-app class="grey lighten-4 ">
    <Navbar/>
    <SearchBar/>   
    <v-content>
      <BookList/>
      <AddBook/>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar'
import SearchBar from '@/components/SearchBar'
import BookList from '@/components/BookList'
import AddBook from '@/components/AddBook'

export default {
  name: 'App',
  components: {Navbar, SearchBar, BookList, AddBook},
  data: () => ({
    //
  }),
};
</script>
