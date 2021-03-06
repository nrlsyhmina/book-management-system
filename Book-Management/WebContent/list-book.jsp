<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Book System</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="style.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

          <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="dashboard.jsp">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">BMS</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="dashboard.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            
             <!-- Heading -->
            <div class="sidebar-heading">
                Publisher
            </div>


             <!-- Nav Item - Author -->
            <li class="nav-item">
                <a class="nav-link" href="add-publisher.jsp">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Register Publisher</span></a>
            </li>
            
              <!-- Nav Item - Author -->
            <li class="nav-item">
                <a class="nav-link" href="ListPublisherController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>View Publisher</span></a>
            </li>
            
              <!-- Divider -->
            <hr class="sidebar-divider">

            
             <!-- Heading -->
            <div class="sidebar-heading">
                Author
            </div>
            
            <!-- Nav Item - Author -->
            <li class="nav-item">
                <a class="nav-link" href="add-author.jsp">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Register Author</span></a>
            </li>
            
            <!-- Nav Item - Author -->
            <li class="nav-item">
                <a class="nav-link" href="ListAuthorController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>View Author</span></a>
            </li>
            
              <!-- Divider -->
            <hr class="sidebar-divider">

            
             <!-- Heading -->
            <div class="sidebar-heading">
                Book
            </div>
            
            <!-- Nav Item - Book -->
            <li class="nav-item">
                <a class="nav-link" href="add-book.jsp">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Add Book</span></a>
            </li>
            
            <!-- Nav Item - Book -->
            <li class="nav-item">
                <a class="nav-link" href="ListBookController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>View Book</span></a>
            </li>
            
              <!-- Divider -->
            <hr class="sidebar-divider">

            
             <!-- Heading -->
            <div class="sidebar-heading">
                User
            </div>
            
             <!-- Nav Item - Book -->
            <li class="nav-item">
                <a class="nav-link" href="add-user.jsp">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Register User</span></a>
            </li>
            
            <!-- Nav Item - Book -->
            <li class="nav-item">
                <a class="nav-link" href="ListUserController">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>View User</span></a>
            </li>

            
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

        </ul>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                      <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>

                    <!-- Topbar Navbar -->
                    <form
                        class="text-right">
                        <div class="input-group">
                        <%
							String uName = (String) session.getAttribute("uName");
							String uIC = (String) session.getAttribute("uIC");
						%>
						Welcome <%=uName%> 
						  <div class="topbar-divider d-none d-sm-block"></div>
                            <a href="login.jsp">Logout</a>
                        </div>
                    </form>

                </nav>
                <!-- End of Topbar -->
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                        <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                    </div>

                    <!-- Content Row -->

                    <div class="row">
                        <div class="col mb-4">

                            <!-- Booking -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">View Author</h6>
                                </div>
                                <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ISBN</th>
                                            <th>User IC</th>
                                            <th>Title</th>
                                            <th>Edition</th>
                                            <th>Publisher</th>
                                            <th>Date of Publish</th>
                                            <th>Number of Pages</th>
                                            <th>Fictional</th>
                                            <th>Language</th>
                                            <th>Update</th>
                                            <th>Delete</th>
                                        </tr>
                                    </thead>
                         
                                    <tbody>
                                    <c:forEach items="${book}" var="book">
                                        <tr>
                                        <td><c:out value="${book.isbn}"/></td>
                                        <td><c:out value="${book.uIC}" /></td>
							            <td><c:out value="${book.bTitle}" /></td>
							            <td><c:out value="${book.bEdition}" /></td>
							            <td><c:out value="${book.pIC}" /></td>
							             <td><c:out value="${book.bDate}" /></td>
							             <td><c:out value="${book.bPage}" /></td>
							             <td><c:out value="${book.bFiction}" /></td>
							             <td><c:out value="${book.bLanguage}" /></td>
							             <td><a href="UpdateBookController?action=update&isbn=<c:out
            value="${book.isbn}" />" class="w3-btn w3-green w3-round-large" >Update</a></td>
              <td><a href="DeleteBookController?action=delete&isbn=<c:out
            value="${book.isbn}" />" class="w3-btn w3-red w3-round-large" onclick="ConfirmDelete()">Delete</a></td>
                                        </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                            </div>

                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Book</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <script src="js.js"></script>
    <script>
    function ConfirmDelete()
    {
      var x = confirm("Are you sure you want to delete?");
      if (x)
          return true;
      else
        return false;
    }
    </script>

</body>
</html>