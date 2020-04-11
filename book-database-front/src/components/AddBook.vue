<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="750px">
      <template v-slot:activator="{ on }">
        <v-btn v-on="on" class="ma-2" outlined color="orange">
          Add Book
          <v-icon>mdi-plus</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-text class="text-left text-light condensed">
          <v-container>
            <v-row>
              <v-col cols="6" sm="4" md="3">
                <v-img v-bind:src="book.image"></v-img>
              </v-col>
              <v-col cols="6" sm="8" md="9">
                <v-text-field v-model="book.isbn" v-on:change.native="search" label="ISBN" required></v-text-field>
                <span class="green--text" v-show="bookInLibrary">
                  This book is in your library
                  <v-icon color="green">check</v-icon>
                </span>
                <v-text-field label="Title" v-model="book.title" required></v-text-field>
                <v-text-field label="Author"></v-text-field>
                <v-text-field label="Pages" v-model="book.pages" type="number"> </v-text-field>
                
              </v-col>
              <v-col cols="10">
                <v-text-field label="Location" type="number"></v-text-field>
              </v-col>
              <v-col cols="2">
                <v-btn v-on="on" class="ma-3" outlined color="orange">
                  <v-icon>mdi-plus</v-icon>
                </v-btn>
              </v-col>
            </v-row>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text v-on:click="dialog = false">Close</v-btn>
          <v-btn color="blue darken-1" text v-on:click="save">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import Book from "@/services/books";

export default {
  data: () => ({
    dialog: false,
    expandLocation: false,
    disableFields: false,
    bookInLibrary: false,
    book: {
      isbn: "",
      title: "",
      pages: "",
      image: ""
    }
  }),
  methods: {
    save() {
      Book.save(this.book).then(response => {
        if (response.data()) {
          alert("book added sucesfuly!"), this.clear(), (this.dialog = false);
        }
      });
    },
    search() {
      Book.extSearchISBN(this.book.isbn).then(response => {
        (this.book.title = response.data.book.title),
          (this.book.pages = response.data.book.pages),
          (this.book.image = response.data.book.image);
      });
    },
    clear() {
      (this.book.isbn = ""),
        (this.book.title = ""),
        (this.book.pages = ""),
        (this.book.image = "");
    }
  },
  mounted() {
    this.clear,
      (this.book.image =
        "https://cdn4.iconfinder.com/data/icons/for-your-interface-free-samples/128/Book-512.png");
  }
};
</script>
