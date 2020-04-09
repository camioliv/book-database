<template>
<nav>
    <v-toolbar  prominent flat app dark color="blue darken-2">
        <v-spacer />
        <v-toolbar-title light> 
                <v-icon large dark>library_books</v-icon>
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
