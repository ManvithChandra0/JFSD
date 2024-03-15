<!doctype html>
<html lang="en">
    <head>
    <title>WEATHER EXPLORER</title>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
  <body>
 
    <%@ include file="usernavbar.jsp" %>
    
     <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Weather Dashboard</title>

    <!-- Favicon: Prevent 404 error in the console -->
    <link rel="icon" href="data:;base64,iVBORw0KGgo=">

    <!-- Bootstrap -->
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
      integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
      crossorigin="anonymous"
    />

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@300;400;700&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
      integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
      crossorigin="anonymous"
    />

    <!-- Custom Stylesheet -->
    <link rel="stylesheet" href="style.css">

  </head>
  <body>

    <!-- Header -->
    <header class="text-center">
      <h1 class="font-weight-bold text-white">
        <i class="fas fa-cloud-sun mr-1"></i>
        Weather Dashboard
      </h1>
      <p id="today" class="h4 text-white"></p>
    </header>

    <!-- Content Container -->
    <div class="container">
      <div class="row">

        <!-- Sidebar: Search + Search History -->
        <aside class="col-sm-4 bg-light px-2 my-3 rounded">

          <!-- Search Input -->
          <form id="search-form" class="form-group mt-1 pt-1">
            <input id="search" class="form-control" type="text" placeholder="Enter City" aria-label="Search"/>
            <button id="search-btn" class="btn btn-block btn-info mt-3" type="submit">
              Search
              <i class="fas fa-search ml-1"></i>
            </button>
          </form>

          <!-- Previous Searches Button (only visible at smaller breakpoints) -->
          <button id="collapse-search-history" class="btn btn-block btn-info" type="button" data-toggle="collapse" data-target="#search-history" aria-expanded="false" aria-controls="collapseExample">
            Previous Searches
          </button>

          <!-- Search History -->
          <ul id="search-history" class="list-group collapse mt-3">
            <li id="delete-history" class="list-group-item list-group-item-info font-weight-bold">
              <i class="fas fa-trash-alt mr-1"></i>
              Delete History
            </li>
          </ul>
        </aside>

        <!-- Main Content: Weather Dashboard -->
        <main class="col-sm-8 px-2 mt-3">

          <!-- Section: Current Weather Data -->
          <section class="card">

            <!-- Current City -->
            <div class="card-header d-flex align-items-center list-group-item-info">
              <p id="city" class="h2 my-0 mr-2"></p>
              <i id="icon" class=""></i>
            </div>
            
            <div class="card-body py-0">
              
              <!-- Current Conditions -->
              <div class="row d-flex align-items-center py-3">
                <div class="col-8 col-md-6 col-lg-4">
                  <p class="h5 font-weight-bold m-0">Conditions:</p>
                </div>
                <div class="col-4 col-md-6 col-lg-8 px-0">
                  <p id="conditions" class="h5 font-weight-light m-0"></p>
                </div>
              </div>

              <!-- Current Temperature -->
              <div class="row bg-light d-flex align-items-center py-3">
                <div class="col-8 col-md-6 col-lg-4">
                  <p class="h5 font-weight-bold m-0">Temperature:</p>
                </div>
                <div class="col-4 col-md-6 col-lg-8 px-0">
                  <p id="temperature" class="h5 font-weight-light m-0"></p>
                </div>
              </div>

              <!-- Current Humidity -->
              <div class="row d-flex align-items-center py-3">
                <div class="col-8 col-md-6 col-lg-4">
                  <p class="h5 font-weight-bold m-0">Humidity:</p>
                </div>
                <div class="col-4 col-md-6 col-lg-8 px-0">
                  <p id="humidity" class="h5 font-weight-light m-0"></p>
                </div>
              </div>

              <!-- Current Wind Speed -->
              <div class="row bg-light d-flex align-items-center py-3">
                <div class="col-8 col-md-6 col-lg-4">
                  <p class="h5 font-weight-bold m-0">Wind Speed:</p>
                </div>
                <div class="col-4 col-md-6 col-lg-8 px-0">
                  <p id="wind-speed" class="h5 font-weight-light m-0"></p>
                </div>
              </div>

              <!-- Current UV Index -->
              <div class="row d-flex align-items-center py-3">
                <div class="col-8 col-md-6 col-lg-4">
                  <p class="h5 font-weight-bold m-0">UV Index:</p>
                </div>
                <div class="col-4 col-md-6 col-lg-8 px-0">
                  <p class="h5 m-0">
                    <span id="uv-index" class="font-weight-light py-1 px-2 rounded"></span>
                  </p>
                </div>
              </div>
            </div>  
          </section>

          <!-- Section: 5-Day Forecast -->
          <section class="card my-3">
            <div class="card-header d-flex align-items-center list-group-item-info py-3">
              <p class="h2 my-0">5-Day Forecast</p>
            </div>

            <div class="card-body py-0">

              <!-- Day 1 -->
              <div class="row d-flex align-items-center py-3">
                <div class="col-2 d-flex justify-content-center">
                  <i id="day-1-icon" class=""></i>
                </div>
                <div class="col-3 pr-0">
                  <p id="day-1-date" class="h5 text-info"></p>
                  <p id="day-1-year" class="h6 font-weight-light m-0"></p>
                </div>
                <div class="col-7">
                  <p id="day-1-conditions" class="h5 text-info"></p>
                  <p class="h6 font-weight-light m-0">
                    <i class="fas fa-thermometer-quarter"></i>
                    <span id="day-1-temp"></span> / 
                    <span id="day-1-humidity"></span>
                  </p>
                </div>
              </div>

              <!-- Day 2 -->
              <div class="row bg-light d-flex align-items-center py-3">
                <div class="col-2 d-flex justify-content-center">
                  <i id="day-2-icon" class=""></i>
                </div>
                <div class="col-3 pr-0">
                  <p id="day-2-date" class="h5 text-info"></p>
                  <p id="day-2-year" class="h6 font-weight-light m-0"></p>
                </div>
                <div class="col-7">
                  <p id="day-2-conditions" class="h5 text-info"></p>
                  <p class="h6 font-weight-light m-0">
                    <i class="fas fa-thermometer-quarter"></i>
                    <span id="day-2-temp"></span> / 
                    <span id="day-2-humidity"></span>
                  </p>
                </div>
              </div>

              <!-- Day 3 -->
              <div class="row bg-light d-flex align-items-center py-3">
                <div class="col-2 d-flex justify-content-center">
                  <i id="day-3-icon" class=""></i>
                </div>
                <div class="col-3 pr-0">
                  <p id="day-3-date" class="h5 text-info"></p>
                  <p id="day-3-year" class="h6 font-weight-light m-0"></p>
                </div>
                <div class="col-7">
                  <p id="day-3-conditions" class="h5 text-info"></p>
                  <p class="h6 font-weight-light m-0">
                    <i class="fas fa-thermometer-quarter"></i>
                    <span id="day-3-temp"></span> / 
                    <span id="day-3-humidity"></span>
                  </p>
                </div>
              </div>

              <!-- Day 4 -->
              <div class="row bg-light d-flex align-items-center py-3">
                <div class="col-2 d-flex justify-content-center">
                  <i id="day-4-icon" class=""></i>
                </div>
                <div class="col-3 pr-0">
                  <p id="day-4-date" class="h5 text-info"></p>
                  <p id="day-4-year" class="h6 font-weight-light m-0"></p>
                </div>
                <div class="col-7">
                  <p id="day-4-conditions" class="h5 text-info"></p>
                  <p class="h6 font-weight-light m-0">
                    <i class="fas fa-thermometer-quarter"></i>
                    <span id="day-4-temp"></span> / 
                    <span id="day-4-humidity"></span>
                  </p>
                </div>
              </div>

              <!-- Day 5 -->
              <div class="row d-flex align-items-center py-3">
                <div class="col-2 d-flex justify-content-center">
                  <i id="day-5-icon" class=""></i>
                </div>
                <div class="col-3 pr-0">
                  <p id="day-5-date" class="h5 text-info"></p>
                  <p id="day-5-year" class="h6 font-weight-light m-0"></p>
                </div>
                <div class="col-7">
                  <p id="day-5-conditions" class="h5 text-info"></p>
                  <p class="h6 font-weight-light m-0">
                    <i class="fas fa-thermometer-quarter"></i>
                    <span id="day-5-temp"></span> / 
                    <span id="day-5-humidity"></span>
                  </p>
                </div>
              </div>
            </div>
          </section>
        </main>
      </div>
    </div>

    

    <!-- jQuery -->
    <script
      src="https://code.jquery.com/jquery-3.5.1.min.js"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous">
    </script>
    
    <!-- Popper.js -->
    <script
      src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
      integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
      crossorigin="anonymous">
    </script>

    <!-- Bootstrap JS -->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
      integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
      crossorigin="anonymous">
    </script>

    <!-- Day.js -->
    <script 
      src="https://cdnjs.cloudflare.com/ajax/libs/dayjs/1.9.8/dayjs.min.js" 
      integrity="sha512-kZ+x2gdehn6OZMWZSp3Vt5R+v9hQTYEATQwaUfWquhxbvNVAy6IRtYs7asdyxKUTqG0I5ZqBqnzcBrpnHJCAGw==" 
      crossorigin="anonymous">
    </script>

    <!-- Application JS -->
    <script src="js/app.js"></script>
  </body>
</html>


  </body>
</html>
