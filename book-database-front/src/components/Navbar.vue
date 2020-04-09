<template>
<nav>
    <v-toolbar flat app>
        <v-spacer />
        <v-toolbar-title class="grey--text text--darken-2">
            <v-icon large color="blue darken-2">library_books</v-icon>
            <span center class="font-weigth-light">Find My Book</span>
        </v-toolbar-title>
        <v-spacer />
    </v-toolbar>
</nav>
</template>

<script>

export default{
    data(){
        return{
            links:[
                {icon: 'dashboard', text: 'Dashboard', route: '/'},
                {icon: 'folder', text: 'My projects', route: '/projects'}
            ]
        }
    }
}

</script>
