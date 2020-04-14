<template>
  <v-container>
    <v-card flat class="text-center text-light" v-if="!books.length">
      <p>Sorry. No books were found...</p>
    </v-card>
    <v-row justify="right">
      <v-col v-for="book of books" :key="book.id" cols="auto">
        <v-card flat width="320">
          <v-row class="fill-height" align="center" justify="center">
            <v-card class="fill-height mx-auto" max-width="344" outlined>
              <v-list-item three-line>
                <v-list-item-avatar height="140" width="95" tile color="grey">
                  <v-img v-bind:src="book.image"></v-img>
                </v-list-item-avatar>
                <v-list-item-content>
                  <div class="body-2 mb-4 font-weight-bold">{{book.location.name}}</div>
                  <v-list-item-title class="text-wrap body-2 mb-4">{{book.title}}</v-list-item-title>
                  <v-list-item-subtitle>{{book.authors.name}}</v-list-item-subtitle>
                </v-list-item-content>
              </v-list-item>
              <v-card-actions>
                <v-btn v-on:click="addBook = true" class="ma-2" outlined color="orange">
                  <v-icon>star</v-icon>
                </v-btn>
                <v-btn v-on:click="addBook = true" class="ma-2" outlined color="orange">
                  <v-icon>delete_outline</v-icon>
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>
import Book from "@/services/books";
export default {
  data() {
    return {
      books: []
    };
  },
  mounted() {
    Book.list().then(response => {
      console.log(response.data);
      this.books = response.data;
    });
  }
};
</script>
