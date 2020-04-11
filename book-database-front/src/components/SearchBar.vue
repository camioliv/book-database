<template>
<div>
  <v-toolbar dark app flat color="blue darken-2" >
    <v-spacer/>
    <v-autocomplete
      v-model="select"
      :loading="loading"
      :items="items"
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
      <v-spacer/>
  </v-toolbar>

  </div>
</template>

<script>

export default{

}

</script>