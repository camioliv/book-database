<template>
  <v-row justify="center">
    <v-dialog v-model="viewBook" persistent max-width="750px">
      <v-card>
        <v-card-title>
          <span class="headline grey--text text--darken-2"></span>
        </v-card-title>
        <v-card-text class="text-left text-light condensed">
          <v-row>
            <v-col cols="6" sm="4" md="3">
              <v-img v-bind:src="book.image"></v-img>
            </v-col>
            <v-col cols="6" sm="8" md="9">
              <v-text-field
                v-model="book.isbn"
                v-on:change.native="searchBookExt"
                label="ISBN"
                required
              ></v-text-field>
              <v-text-field label="Title" v-model="book.title" required></v-text-field>
              <div v-for="(author, index) in book.authors" v-bind:key="index">
                <v-text-field label="Author" v-model="author.name"></v-text-field>
              </div>
              <v-text-field label="Pages" v-model="book.pages" type="number"></v-text-field>
            </v-col>
            <v-col cols="10">
              <v-autocomplete
                v-model="book.location"
                :loading="loading"
                :items="locations"
                item-text="name"
                item-value="id"
                :search-input.sync="searchLocations"
                no-filter
                hide-no-data
                clearable
                return-object
                label="Location"
                required
              ></v-autocomplete>
            </v-col>
            <v-col cols="2">
              <v-btn v-on:click="addLocation = true" class="ma-3" outlined color="orange">
                <v-icon>mdi-plus</v-icon>
              </v-btn>
            </v-col>
          </v-row>
          <v-rating
            v-model="book.ratings.stars"
            background-color="orange lighten-3"
            color="orange"
            medium
          ></v-rating>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text v-on:click="$emit('update:viewBook', false)">Close</v-btn>
          <v-btn color="blue darken-1" text v-on:click="saveBook">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog v-model="addLocation" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline grey--text text--darken-2">Add Location</span>
        </v-card-title>
        <v-card-text class="text-left text-light condensed">
          <v-row>
            <v-col cols="6" sm="8" md="9">
              <v-text-field label="Description" v-model="location.name" required></v-text-field>
            </v-col>
            <v-col cols="2" required>
              <v-radio-group v-model="typeLocation">
                <v-radio true-value label="Shelf" value="1"></v-radio>
                <v-radio label="Box" value="2"></v-radio>
              </v-radio-group>
            </v-col>
          </v-row>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text v-on:click="addLocation = false">Close</v-btn>
          <v-btn color="blue darken-1" text v-on:click="saveLocation">Save</v-btn>
        </v-card-actions>
      </v-card>
      <v-alert v-model="alert" :type="type" dismissible="true">{{message}}</v-alert>
    </v-dialog>
  </v-row>
</template>

<script>
import Book from "@/services/books";
import Location from "@/services/locations";
import Shelf from "@/services/shelves";
import Box from "@/services/boxes";

export default {
  props: {
    viewBook: Boolean,
    bookParent: Object
  },
  data: () => ({
    alert: false,
    message: "",
    type: "success",
    addLocation: false,
    location: {
      name: ""
    },
    refreshLocations: false,
    locations: {
      id: 0,
      name: ""
    },
    loading: false,
    searchLocations: null,
    typeLocation: null,
    box: {
      name: ""
    },
    shelf: {
      name: ""
    },
    book: {
      isbn: "",
      title: "",
      pages: "",
      image: "",
      lastViewd: "",
      authors: [{ name: "" }],
      location: {
        id: 0,
        name: ""
      },
      ratings: {
        user: {
          id: 1,
          name: "Guest"
        },
        stars: 0
      }
    }
  }),

  watch: {
    searchLocations(val) {
      if (this.locations.length > 0 && !this.refreshLocations) return;
      if (this.loading) return;
      if (val == null) return;
      this.loading = true;
      Location.list()
        .then(response => {
          this.locations = response.data;
        })
        .catch(error => {
          (this.alert = true), (this.message = error), (this.type = "error");
        })
        .finally(
          () => ((this.loading = false), (this.refreshLocations = false))
        );
    },
    viewBook() {
      if (this.viewBook) {
        this.book = Object.assign({}, this.bookParent);
        this.book.ratings.user = Object.assign({}, this.user);
        var currentDate = new Date();
        this.book.lastViewd = currentDate;
        this.saveBook();
      }
    }
  },
  methods: {
    saveBook() {
      this.book.ratings.user.id = 1;
      Book.update(this.book)
        .then(
          (this.alert = true),
          (this.message = "Book Sucefully Saved"),
          (this.type = "success")
        )
        .catch(error => {
          (this.alert = true), (this.message = error), (this.type = "error");
        });
    },
    saveAndClose() {
      this.saveBook();
      this.$emit("update:viewBook", false);
    },
    saveLocation() {
      if (this.typeLocation == 1) {
        (this.shelf = this.location),
          Shelf.save(this.shelf)
            .then(response => {
              (this.alert = true),
                (this.message = "Shelf Sucefully Saved"),
                (this.type = "success"),
                (this.book.location = response.data),
                (this.addLocation = false),
                (this.refreshLocations = true);
            })
            .catch(error => {
              (this.alert = true),
                (this.message = error),
                (this.type = "error");
            });
        this.addLocation = false;
      } else if (this.typeLocation == 2) {
        (this.box = this.location),
          Box.save(this.box)
            .then(response => {
              (this.alert = true),
                (this.message = "Shelf Sucefully Saved"),
                (this.type = "success"),
                (this.book.location = response.data),
                (this.addLocation = false),
                (this.refreshLocations = true);
            })
            .catch(error => {
              (this.alert = true),
                (this.message = error),
                (this.type = "error");
            });
      }
    },

    searchBook() {
      Book.listById(this.props.bookId).then(response => {
        this.book = response.data;
      });
    },

    searchBookExt() {
      Book.extSearchISBN(this.book.isbn).then(response => {
        (this.book.title = response.data.book.title),
          (this.book.pages = response.data.book.pages),
          (this.book.image = response.data.book.image);

        if (response.data.book.authors.length > 0) {
          (this.book.authors = []),
            response.data.book.authors.forEach(item => {
              var author = new Object();
              author.name = item;
              this.book.authors.push(author);
            });
        }
      });
    }
  },
  mounted() {
    Location.list()
      .then(response => {
        this.locations = response.data;
      })
      .catch(error => {
        console.log(error);
      })
      .finally(() => ((this.loading = false), (this.refreshLocations = false)));
  }
};
</script>
