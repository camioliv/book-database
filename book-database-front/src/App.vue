<template>
<div>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Book Management</title>
    <meta name="description" content="Application for book management">



    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>

<body class="homepage">

    <nav class="navbar"  >


    </nav>

    <header class="bg-info text-light text-center pt-3 pb-5" data-toggle="navigation-sticky">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 col-md-10">
                    <h1>Book Search
                    </h1>
                    <div class="my-4">

                        <form action="/search/" class="search-form">
                            <div class="input-group">
                                <input class="form-control form-control-lg border-0 autocomplete" type="search" name="q"
                                    placeholder="Search for books, authors, titles..." value="" autofocus
                                    autocomplete="off">
                                <div class="input-group-append">
                                    <button class="btn btn-light btn-lg px-4 border-0" type="submit">
                                        Search
                                        <svg width="35" height="24" class="ui-icon align-text-top text-white">
                                            
                                        </svg>

                                    </button>
                                </div>
                            </div>


                            <input type="hidden" name="from" value="homepage">
                        </form>
                        <div class="filter-list pt-2"></div>
                    </div>
                </div>
            </div>
        </div>
    </header>






    <footer class="py-5 border-top">
        <div class="container">
            <div class="pt-5">
                <div class="row">
                    <div class="col-lg-9">
                        <p class="mt-5 text-secondary">Made by Camila Oliveira. Spokane, 2020</p>
                    </div>

                </div>
            </div>
        </div>
    </footer>


</body>
</div>
</template>

<script>

</script>

<style>

</style>
