<nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <img src="../${reporter.image}" style="width: 64px; height: 64px; border-radius: 50%;border-style: solid"/><br/>
                                    <span data-feather="home"></span>
                                    <i class="fa fa-home"></i>Dashboard <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="addNews.jsp">
                                    <span data-feather="file"></span>
                                    <i class="fa fa-plus"></i>Add News
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewNews.jsp">
                                    <span data-feather="shopping-cart"></span>
                                    <i class="fa fa-pencil"></i> Update News
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="editReporter.jsp">
                                    <span data-feather="users"></span>
                                    <i class="fa fa-user"></i> Update Profile
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <span data-feather="bar-chart-2"></span>
                                    <i class="fa fa-key"></i>  Change Password
                                </a>
                            </li>
                            
                        </ul>

                        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>Report Section</span>
                            <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                                <span data-feather="plus-circle"></span>
                            </a>
                        </h6>
                        <ul class="nav flex-column mb-2">
                            <li class="nav-item">
                                <a class="nav-link" href="viewPendingNews.jsp">
                                    <span data-feather="file-text"></span>
                                    <i class="fa fa-adjust"></i>      Pending News
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewApprovedNews.jsp">
                                    <span data-feather="file-text"></span>
                                    <i class="fa fa-times-rectangle"></i> Approved News
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewRejectedNews.jsp">
                                    <span data-feather="file-text"></span>
                                    <i class="fa fa-check-square-o"></i> Rejected News
                                </a>
                            </li>
                          
                        </ul>
                    </div>
                </nav>