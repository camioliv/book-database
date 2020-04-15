<template>
  <v-app class="grey lighten-4 ">
    <Navbar/>
    <SearchBar/> 
    <RecomendationBar/>  
    <v-content>
      <AddBook/>      
      <BookList/>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script>
import Navbar from '@/components/Navbar'
import SearchBar from '@/components/SearchBar'
import RecomendationBar from '@/components/RecomendationBar'
import BookList from '@/components/BookList'
import AddBook from '@/components/AddBook'

export default {
  name: 'App',
  components: {Navbar, SearchBar, RecomendationBar, BookList, AddBook},
  data: () => ({
    //
  })
};
</script>
