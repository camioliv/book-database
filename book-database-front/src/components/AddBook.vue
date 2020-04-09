<template>
  <v-row justify="center">
    <v-dialog v-model="dialog" persistent max-width="500px">
      <template v-slot:activator="{ on }">
              <v-btn v-on="on" class="ma-2" outlined color="orange">
          Add Book
          <v-icon>mdi-plus</v-icon>
        </v-btn>
      </template>
      <v-card>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12" sm="12" md="12">
                <v-text-field label="ISBN" required></v-text-field>
              </v-col>
              <v-col cols="12" sm="12" md="12">
                <v-text-field label="Title" required></v-text-field>
              </v-col>              
              <v-col cols="12">
                <v-text-field label="Author" required></v-text-field>
              </v-col>
              <v-col cols="6">
                <v-text-field label="Pages" type="password" required></v-text-field>
              </v-col>

              <v-col cols="12" sm="6">
                <v-autocomplete
                  :items="['Romance', 'Drama', 'History', 'Coding']"
                  label="Topics"
                  multiple
                ></v-autocomplete>
              </v-col>
            </v-row>
          </v-container>
          <small>*indicates required field</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" text @click="dialog = false">Close</v-btn>
          <v-btn color="blue darken-1" text @click="dialog = false">Save</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
export default {};
</script>
