<template>
  <v-app class="grey lighten-4">
    <div>
      <v-sheet tile color="blue darken-3" dark class="pt-12">
        <v-container fluid class="px-0 pb-0 transparent">
          <v-row justify="center">
            <v-col class="text-center">
              <v-icon large dark>library_books</v-icon>
              <span center class="font-weight-bold display-1">  Find My Book</span>
            </v-col>
          </v-row>
        </v-container>
      </v-sheet>
      <!--SearchBar -->
      <v-sheet tile color="blue darken-2" dark>
        <v-container class="pa-0">
          <v-row justify="center" align-content="center" align="center">
            <v-col cols="7">
              <v-text-field
                  class="subtitle-1 font-weight-medium"
                  hide-details
                  single-line
                  flat
                  label="Search for Books, Authors, ISBN and Topics"
                  solo-inverted
                  v-model="query"
                  @keydown.enter="SearchBooks"></v-text-field>
            </v-col>
            <v-col class="flex-shrink-1 flex-grow-0 pa-0">
              <v-btn icon v-on:click="SearchBooks" dark>
                <v-icon>search</v-icon>
              </v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-sheet>
    </div>
    <!--Recommendations -->
    <v-container>
      <v-row>
        <v-col cols="3">
          <v-card color="cyan darken-2" dark height="70px">
            <v-card-title class="subtitle-1" @click="Favorites">
              <v-icon large dark>favorite</v-icon>My favorites
            </v-card-title>
          </v-card>
        </v-col>

        <v-col cols="3">
          <v-card dark color="red darken-2" height="70px">
            <v-card-title class="subtitle-1" @click="Recommend">
              <v-icon large dark>person_pin</v-icon>Recomended for me
            </v-card-title>
          </v-card>
        </v-col>

        <v-col cols="3">
          <v-card dark color="blue darken" height="70px">
            <v-card-title class="subtitle-1" @click="LightRead">
              <v-icon large dark>timer</v-icon>Light Read
            </v-card-title>
          </v-card>
        </v-col>

        <v-col cols="3">
          <v-card dark color="orange darken-2" height="70px">
            <v-card-title class="subtitle-1" @click="ForgottenTreasures">
              <v-icon large dark>local_library</v-icon>Forgotten treasures
            </v-card-title>
          </v-card>
        </v-col>
        <v-spacer></v-spacer>
      </v-row>
    </v-container>
    <v-content>
      <AddBook></AddBook>
      <ViewBook v-bind:viewBook.sync="viewBook" v-bind:bookParent="book" ></ViewBook>
      <!--ListOfBooks -->
      <v-container>
        <v-card flat class="text-center text-light" v-if="!books.length">
          <p>Sorry. No books were found...</p>
        </v-card>

        <v-row >
          <v-col v-for="book of books" :key="book.id" cols="auto">
            <v-card flat width="320" @click="OpenBook(book)">
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
                </v-card>
              </v-row>
            </v-card>
          </v-col>
        </v-row>
        
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
import ViewBook from "@/components/ViewBook";
import AddBook from "@/components/AddBook";
import Book from "@/services/books";

export default {
  name: "App",
  components: { ViewBook, AddBook },
  data: () => ({
    viewBook: false,
    query: "",
    book: {
      isbn: "",
      title: "",
      pages: "",
      image: "",
      authors: [{ name: "" }],
      location: {
        id: 0,
        name: ""
      }
    },
    books: {}
  }),
  watch: {
    viewBook() {
      if (!this.viewBook) {
        this.SearchBooks();
      }
    }
  },
  methods: {
    SearchBooks() {
      Book.list(this.query)
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    OpenBook: function(book) {
      this.viewBook = true;
      this.book = book;
    },
    LightRead() {
      Book.listLessThanPages(120)
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    Recommend() {
      Book.recommend(this.user.id)
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    ForgottenTreasures() {
      Book.notViewdFrequently()
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
    Favorites() {
      Book.favorites(this.user.id)
        .then(response => {
          this.books = response.data;
        })
        .catch(error => {
          console.log(error);
        });
    },
             
  }
};
</script>
