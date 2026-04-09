package com.serge.medlife.screens.navigation

import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.serge.medlife.screens.history.HistoryScreen
import com.serge.medlife.screens.homeScreen.DoctorHomeScreen
import com.serge.medlife.screens.homeScreen.HomeScreen
import com.serge.medlife.screens.homeScreen.healthShop.ShoppingHomePage
import com.serge.medlife.screens.homeScreen.healthShop.cart.Cart
import com.serge.medlife.screens.loginScreen.LoginScreen
import com.serge.medlife.screens.profile.ProfileScreen
import com.serge.medlife.screens.registerScreen.DoctorConfirmation
import com.serge.medlife.screens.registerScreen.RegisterScreen
import com.serge.medlife.screens.servicesScreen.ServicesScreen
import com.serge.medlife.screens.servicesScreen.article.ArticleList
import com.serge.medlife.screens.servicesScreen.article.ArticlePage
import com.serge.medlife.screens.servicesScreen.article.DisplayArticle
import com.serge.medlife.screens.servicesScreen.chatDoc.AppointmentSuccess
import com.serge.medlife.screens.servicesScreen.chatDoc.ChatScreen
import com.serge.medlife.screens.servicesScreen.chatDoc.Confirmation
import com.serge.medlife.screens.servicesScreen.chatDoc.ConsultDoctorScreen
import com.serge.medlife.screens.servicesScreen.chatDoc.DoctorDetails
import com.serge.medlife.screens.servicesScreen.hospitals.HospitalMap
import com.serge.medlife.screens.servicesScreen.medicationReminder.MedicationReminder
import com.serge.medlife.screens.servicesScreen.medicationReminder.ReminderFilled
import com.serge.medlife.screens.splashScreen.AuthSplashScreen
import com.serge.medlife.screens.splashScreen.HPager
import com.serge.medlife.screens.splashScreen.Splashscreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(
    navHostController: NavHostController,
    sharedPreferences: SharedPreferences,
    modifier: Modifier
) {
    val isOnBoarded = sharedPreferences.getBoolean("isOnBoarded", false)
    val isPatientLoggedIn = sharedPreferences.getBoolean("isPatientLoggedIn", false)
    val isDoctorLoggedIn = sharedPreferences.getBoolean("isDoctorLoggedIn", false)
    val isPatient = sharedPreferences.getBoolean("isPatient", false)
    val isDoctor = sharedPreferences.getBoolean("isDoctor", false)

    NavHost(navHostController, startDestination = NavRoute.Splash.path) {
        addHomeScreen(navHostController, this)
        addDoctorHomeScreen(navHostController, this, sharedPreferences)
        addSplashScreen(navHostController, this, isOnBoarded, isPatientLoggedIn, isDoctorLoggedIn, isPatient, isDoctor)
        addWalkthroughScreen(navHostController, this, sharedPreferences)
        addRegisterScreen(navHostController, this, sharedPreferences)
        addDoctorRegisterConfirmationScreen(navHostController, this)
        addLoginScreen(navHostController, this, sharedPreferences)
        addProfileScreen(navHostController, this, sharedPreferences)
        addHistoryScreen(navHostController, this)
        addServicesScreen(navHostController, this)
        addAuthSplash(navHostController, this)
        addChatDocScreen(navHostController, this)
        addChatScreen(navHostController, this)
        addCartScreen(navHostController, this)
        addHealthShop(navHostController, this)
        addDocDtls(navHostController, this)
        addAppointmentScreen(navHostController, this)
        addAppointmentSuccessScreen(navHostController, this)
        addGoogleMapScreen(navHostController, this)
        addMedicineScreen(navHostController, this)
        addArticleHome(navHostController, this)
        addReadArticleScreen(navHostController, this)
        addArticleGridScreen(navHostController, this)
        addSavedReminder(navHostController, this)
    }
}

fun addHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.Main.path
    ) {
        HomeScreen(
            navigateToConsultDoc = {category ->
                navHostController.navigate(NavRoute.ChatDoc.createRoute(category))
            },
            navigateToChatDoc = {
                navHostController.navigate(NavRoute.Chat.path)
            },
            navigateToNotifications = {
                navHostController.navigate(NavRoute.Notifications.path)
            },
            navigateToCart = {
                navHostController.navigate(NavRoute.Cart.path)
            },
            navigateToHealthShop = {
                navHostController.navigate(NavRoute.HealthShop.path)
            },
            navigateToHospital = {
                navHostController.navigate(NavRoute.HospitalMap.path)
            },
            navigateToArticle = {
                navHostController.navigate(NavRoute.ArticleRead.path)
            },
            navigateToCategoryDoc = { category ->
                Log.d("NavGraph", "Category received: $category")
                navHostController.navigate(NavRoute.ChatDoc.createRoute(category))
            }
        )
    }
}

fun addDoctorHomeScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(NavRoute.DoctorMain.path) {
        DoctorHomeScreen(
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path) {
                    popUpTo(navHostController.graph.findStartDestination().id) {
                        inclusive = true
                    }
                }
            },
            sharedPreferences = sharedPreferences
        )
    }
}

fun addSplashScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    isOnBoarded: Boolean,
    isPatientLoggedIn: Boolean,
    isDoctorLoggedIn: Boolean,
    isPatient: Boolean,
    isDoctor: Boolean
) {
    navGraphBuilder.composable(
        route = NavRoute.Splash.path
    ) {
        Splashscreen(
            navigateToOnBoard = {
                if (isOnBoarded && isPatientLoggedIn && isPatient) {
                    navHostController.navigate(NavRoute.Main.path)
                }
                else if (isOnBoarded && isDoctorLoggedIn && isDoctor) {
                    navHostController.navigate(NavRoute.DoctorMain.path)
                }
                else if (isOnBoarded) {
                    navHostController.navigate(NavRoute.AuthSplash.path)
                }
                else {
                    navHostController.navigate(NavRoute.Walkthrough.path)
                }
            }
        )
    }
}

fun addWalkthroughScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences,
) {
    navGraphBuilder.composable(
        route = NavRoute.Walkthrough.path
    ) {
        HPager(
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path)
            }, sharedPreferences
        )
    }
}

fun addProfileScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Profile.path, arguments = listOf(navArgument("userName") {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        }, navArgument("email") {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        ProfileScreen(
            navigateToAuthSplash = {
                navHostController.navigate(NavRoute.AuthSplash.path) {
                    popUpTo(0)
                }
            },
            sharedPreferences = sharedPreferences
        )
    }
}

fun addServicesScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Services.path
    ) {
        ServicesScreen(
            back = { navHostController.popBackStack() }, navHostController
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addHistoryScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.History.path
    ) {
        HistoryScreen(
            navigateToChatDoc = { navHostController.navigate(NavRoute.ChatDoc.createRoute("All")) })
    }
}

fun addAuthSplash(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AuthSplash.path
    ) {
        AuthSplashScreen(
            navigateToRegister = { navHostController.navigate(NavRoute.Register.path) },
            navigateToLogin = { navHostController.navigate(NavRoute.Login.path) })
    }
}

fun addRegisterScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Register.path,
    ) {
        RegisterScreen(
            navigateToLoginScreen = {
            navHostController.navigate(NavRoute.Login.path)
        }, navigateToHomeScreen = {
            navHostController.navigate(NavRoute.Main.path) {
                popUpTo(NavRoute.AuthSplash.path) {
                    inclusive = true
                }
            }
        }, navigateToConfirmationScreen = {
            navHostController.navigate(NavRoute.DoctorRegisterConfirmation.path)
        }, sharedPreferences
        )
    }
}

fun addDoctorRegisterConfirmationScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.DoctorRegisterConfirmation.path
    ) {
        DoctorConfirmation(
            navigateToLoginScreen = {navHostController.navigate(NavRoute.Login.path)}
        )
    }
}

fun addLoginScreen(
    navHostController: NavHostController,
    navGraphBuilder: NavGraphBuilder,
    sharedPreferences: SharedPreferences
) {
    navGraphBuilder.composable(
        route = NavRoute.Login.path
    ) {
        LoginScreen(
            navigateToHomeScreen = {
            navHostController.navigate(NavRoute.Main.path) {
                popUpTo(NavRoute.AuthSplash.path) {
                    inclusive = true
                }
            }
        },
            navigateToRegister = { navHostController.navigate(NavRoute.Register.path) },
            navigateToDoctorHome = { navHostController.navigate(NavRoute.DoctorMain.path){
                popUpTo(NavRoute.AuthSplash.path) {
                    inclusive = true
                }
            } },
            sharedPreferences
        )
    }
}

fun addChatDocScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ChatDoc.path,
        arguments = listOf(
            navArgument("category") {
                type = NavType.StringType
                defaultValue = "All"
            }
        )
    ) {backStackEntry ->
        val category = Uri.decode(
            backStackEntry.arguments?.getString("category") ?: "All"
        )
        Log.d("NavGraph", "Category received: $category")
        ConsultDoctorScreen(
            category = category,
            back = { navHostController.popBackStack() },
            navigateToDocDtls = { doctorName, spec, gender ->
            navHostController.navigate(NavRoute.DocDtls.path.plus("&name=$doctorName&specialization=$spec&gender=$gender"))
        })
    }
}

fun addChatScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Chat.path
    ) {
        ChatScreen(
            back = {navHostController.popBackStack()}
        )
    }
}

fun addCartScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Cart.path
    ) {
        Cart(
            back = { navHostController.popBackStack() },
            navigateToHealthShop = {
                navHostController.navigate(NavRoute.HealthShop.path)
            }
        )
    }
}

fun addHealthShop(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.HealthShop.path
    ) {
        ShoppingHomePage(
            back = { navHostController.navigate(NavRoute.Main.path) },
         navigateToCart = {
            navHostController.navigate(NavRoute.Cart.path)
         }
        )
    }
}

fun addGoogleMapScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        NavRoute.HospitalMap.path
    ) {
        HospitalMap(
            back = {navHostController.popBackStack()}
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addDocDtls(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.DocDtls.path,
        arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("specialization") {
                type = NavType.StringType
                defaultValue = ""
            },
            navArgument("gender") {
                type = NavType.StringType
                defaultValue = ""
            }
        )
    ) {
        val doctorName = Uri.decode(it.arguments?.getString("name") ?: "")
        val doctorSpecialization = Uri.decode(it.arguments?.getString("specialization") ?: "")
        val doctorGender = Uri.decode(it.arguments?.getString("gender") ?: "")
        DoctorDetails(
            navigateToChat = { navHostController.navigate(NavRoute.Chat.path)},
            back = { navHostController.popBackStack() },
            navigateToAppointment = { doctorName, doctorSpecialization, doctorGender, date, hours ->
                navHostController.navigate(
                    NavRoute.Appointment.path.plus(
                        "/${doctorName}/${doctorSpecialization}/${doctorGender}/${date}/${hours}"
                    )
                )
            },
            name = doctorName,
            specialization = doctorSpecialization,
            gender = doctorGender
        )
    }
}


fun addAppointmentScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.Appointment.path.plus(
            "/{doctorName}/{doctorSpecialization}/{doctorGender}/{date}/{hours}"
        ), arguments = listOf(
            navArgument("doctorName") {
                type = NavType.StringType
            },
            navArgument("doctorSpecialization") {
                type = NavType.StringType
            },
            navArgument("doctorGender") {
                type = NavType.StringType
            },
            navArgument("date") {
            type = NavType.StringType
        }, navArgument("hours") {
            type = NavType.StringType
        })
    ) {
        val doctorName = it.arguments?.getString("doctorName").toString()
        val doctorSpecialization = it.arguments?.getString("doctorSpecialization").toString()
        val doctorGender = it.arguments?.getString("doctorGender").toString()
        val appointmentDate = Uri.decode(it.arguments?.getString("date").toString())
        val appointmentHours = Uri.decode(it.arguments?.getString("hours").toString())
        Confirmation(
            back = { navHostController.popBackStack() },
            navigateToAppointmentSuccess =
                { navHostController.navigate(NavRoute.AppointmentSuccess.path) },
            doctorName = doctorName,
            doctorSpecialization = doctorSpecialization,
            doctorGender = doctorGender,
            appointmentDate = appointmentDate,
            appointmentHours = appointmentHours
        )
    }
}

fun addAppointmentSuccessScreen(
    navHostController: NavHostController, navGraphBuilder: NavGraphBuilder
) {
    navGraphBuilder.composable(
        route = NavRoute.AppointmentSuccess.path
    ) {
        AppointmentSuccess(
            navigateToHistory = {
                navHostController.navigate(NavRoute.History.path) {
                    popUpTo(NavRoute.Services.path) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

fun addMedicineScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.AddMed.path
    ) {
        MedicationReminder(
            navigateToSavedReminder = {
                navHostController.navigate(NavRoute.SavedReminder.path)
            },
            back = {
                navHostController.popBackStack()
            }
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun addSavedReminder(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.SavedReminder.path
    ) {
        ReminderFilled(
            back = {
                navHostController.navigate(NavRoute.Main.path) {
                    popUpTo(NavRoute.Main.path) {
                        inclusive = false
                    }
                }
            },
            navigateToAddMed = {
                navHostController.navigate(NavRoute.AddMed.path)
            }
        )
    }
}

fun addArticleHome(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ArticleHome.path
    ) {
        ArticleList(back = { navHostController.popBackStack() }, navigateToArticle = {
            navHostController.navigate(NavRoute.ArticleRead.path)
        }, navigateToArticleGrid = {
            navHostController.navigate(NavRoute.ArticleGrid.path)
        })
    }
}

fun addReadArticleScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ArticleRead.path
    ) {
        DisplayArticle(
            back = { navHostController.popBackStack() })
    }
}

fun addArticleGridScreen(navHostController: NavHostController, navGraphBuilder: NavGraphBuilder) {
    navGraphBuilder.composable(
        route = NavRoute.ArticleGrid.path
    ) {
        ArticlePage(
            back = { navHostController.popBackStack() },
            navigateToArticle = {
                navHostController.navigate(NavRoute.ArticleRead.path)
            },
        )
    }
}