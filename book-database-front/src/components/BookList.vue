<template>
  <v-container>
    <v-card flat class="text-center text-light" v-if="!books.length">
      <p>Sorry. No books were found...</p>
    </v-card>
    <v-row justify="right">
      <v-col v-for="book of books" :key="book.id" flat cols="auto">
        <v-card :elevation="5" height="170" width="344">
          <v-row class="fill-height" align="center" justify="center">
            <v-card class="fill-height mx-auto" max-width="344" outlined>
              <v-list-item three-line>
                <v-list-item-content>
                  <div class="overline mb-4">OVERLINE</div>
                  <v-list-item-title class="headline mb-1">{{book.title}}</v-list-item-title>
                  <v-list-item-subtitle>Greyhound divisely hello coldly fonwderfully</v-list-item-subtitle>
                </v-list-item-content>

                <v-list-item-avatar tile size="80" color="grey"></v-list-item-avatar>
              </v-list-item>

              <v-card-actions>
                <v-btn text>Button</v-btn>
                <v-btn text>Button</v-btn>
              </v-card-actions>
            </v-card>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-card flat class="text-center text-light regular" v-if="books.length">
      <v-pagination v-model="page" :length="books.length" :total-visible="7"></v-pagination>
    </v-card>
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
