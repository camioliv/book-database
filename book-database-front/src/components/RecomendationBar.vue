<template>
  <v-container>
      
    <v-row >
       
      <v-col cols="3">
        <v-card color="cyan darken-2" dark height="70px">
          <v-card-title class="subtitle-1 ">
              <v-icon large dark>favorite</v-icon>
                My favorites</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-col>

      <v-col cols="3">
        <v-card dark color="red darken-2" height="70px" >
          <v-card-title class="subtitle-1 ">
              <v-icon large dark>person_pin</v-icon>
                Recomended for me</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-col>

      <v-col cols="3">
        <v-card  dark color="blue darken" height="70px">
          <v-card-title class="subtitle-1 ">
              <v-icon large dark>stars</v-icon>
                Best sellers in my collection</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-col>

      <v-col cols="3">
        <v-card dark color="orange darken-2" height="70px">
          <v-card-title class="subtitle-1 ">
              <v-icon large dark>local_library</v-icon>
                Forgotten treasures</v-card-title>
          <v-card-actions>
            <v-spacer></v-spacer>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-spacer></v-spacer>
    </v-row>
    
  </v-container>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>
