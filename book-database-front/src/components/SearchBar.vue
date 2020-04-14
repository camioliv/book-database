<template>
  <div>
    <v-toolbar dark app flat color="blue darken-2">
      <v-spacer />
      <v-autocomplete
        v-model="select"
        :loading="loading"
        :items="books"
        :search-input.sync="search"
        cache-items
        flat
        hide-no-data
        hide-details
        label="Search for Books, Authors, ISBN and topics"
        solo-inverted
      ></v-autocomplete>
      <v-btn icon>
        <v-icon>search</v-icon>
      </v-btn>
      <v-spacer />
    </v-toolbar>
  </div>
</template>

<script>
import Book from "@/services/books";

export default {
  data: () => ({
    loading: false,
    books: [],
    select: null,
    search: null
  }),

  watch: {
    search() {
      if (this.books.length > 0) return;
      if (this.loading) return;
      this.loading = true;

      Book.list()
        .then(response => response.json())
        .then(response => {
          this.books = response;
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>