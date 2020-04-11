<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="600px">
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
              <v-col cols="6" sm="12" md="12">
                <v-text-field  v-model="book.isbn" label="ISBN" type="number" required></v-text-field>
                <span class="green--text" v-show="bookInLibrary">This book is in your library
                  <v-icon color="green">check</v-icon>
                </span>
              </v-col>
              <v-col cols="6" sm="12" md="12">
                <v-text-field label="Title" v-model="book.title" required></v-text-field>
              </v-col>
              <v-col cols="10">
                <v-text-field label="Author" ></v-text-field>
              </v-col>
              <v-col cols="2">
                <v-text-field label="Pages" v-model="book.pages"  type="number" required></v-text-field>
              </v-col>
              <v-col cols="10">
                <v-text-field label="Location"  type="number"></v-text-field>
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
import Book from '@/services/books'

export default {
  data(){
    return {
      dialog:false,
      expandLocation: false,
      disableFields: false,
      bookInLibrary: false,
      book:{
        isbn:'',
        title:'',
        pages:''
      }
    }
  },
  methods:{
    save(){
      Book.save(this.book).then(response =>{
        if (response.data()){
          alert('book added sucesfuly!')
          this.book = []
        }
      })
    }
  }
};
</script>
