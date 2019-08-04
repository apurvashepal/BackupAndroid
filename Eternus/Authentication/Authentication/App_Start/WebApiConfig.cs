﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using System.Web.Cors;
using System.Net.Http.Formatting;
using Newtonsoft.Json.Serialization;
using System.Web.Http.Cors;

namespace Authentication
{
	public static class WebApiConfig
	{
		private static JsonMediaTypeFormatter jsonFormatter;

		public static void Register(HttpConfiguration config)
		{
			// Web API configuration and services
			EnableCorsAttribute cors = new EnableCorsAttribute("*", "*", "*");
			config.EnableCors(cors);

			// Web API routes
			config.MapHttpAttributeRoutes();

			config.Routes.MapHttpRoute(
				name: "DefaultApi",
				routeTemplate: "api/{controller}/{id}",
				defaults: new { id = RouteParameter.Optional }


				);
			var jsonFormatter = config.Formatters.OfType<JsonMediaTypeFormatter>().First();
			jsonFormatter.SerializerSettings.ContractResolver = new CamelCasePropertyNamesContractResolver();  
			
		}
	}
}
