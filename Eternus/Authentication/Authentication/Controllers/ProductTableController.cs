using Authentication.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;

namespace Authentication.Controllers
{
    public class ProductTableController : ApiController
    {
		private ProductDatabaseEntities db = new ProductDatabaseEntities();

		// GET: api/ProductTables
		public IQueryable<ProductTable> GetProductTables()
		{
			return db.ProductTables;
		}

		// GET: api/ProductTables/5
		[ResponseType(typeof(ProductTable))]
		public IHttpActionResult GetProductTable(int id)
		{
			ProductTable productTable = db.ProductTables.Find(id);
			if (productTable == null)
			{
				return NotFound();
			}

			return Ok(productTable);
		}

		// PUT: api/ProductTables/5
		[ResponseType(typeof(void))]
		public IHttpActionResult PutProductTable(int id, ProductTable productTable)
		{
			if (!ModelState.IsValid)
			{
				return BadRequest(ModelState);
			}

			if (id != productTable.Id)
			{
				return BadRequest();
			}

			db.Entry(productTable).State = EntityState.Modified;

			try
			{
				db.SaveChanges();
			}
			catch (DbUpdateConcurrencyException)
			{
				if (!ProductTableExists(id))
				{
					return NotFound();
				}
				else
				{
					throw;
				}
			}

			return StatusCode(HttpStatusCode.NoContent);
		}

		// POST: api/ProductTables
		[ResponseType(typeof(ProductTable))]
		public IHttpActionResult PostProductTable(ProductTable productTable)
		{
			if (!ModelState.IsValid)
			{
				return BadRequest(ModelState);
			}

			db.ProductTables.Add(productTable);

			try
			{
				db.SaveChanges();
			}
			catch (DbUpdateException)
			{
				if (ProductTableExists(productTable.Id))
				{
					return Conflict();
				}
				else
				{
					throw;
				}
			}

			return CreatedAtRoute("DefaultApi", new { id = productTable.Id }, productTable);
		}

		// DELETE: api/ProductTables/5
		[ResponseType(typeof(ProductTable))]
		public IHttpActionResult DeleteProductTable(int id)
		{
			ProductTable productTable = db.ProductTables.Find(id);
			if (productTable == null)
			{
				return NotFound();
			}

			db.ProductTables.Remove(productTable);
			db.SaveChanges();

			return Ok(productTable);
		}

		protected override void Dispose(bool disposing)
		{
			if (disposing)
			{
				db.Dispose();
			}
			base.Dispose(disposing);
		}

		private bool ProductTableExists(int id)
		{
			return db.ProductTables.Count(e => e.Id == id) > 0;
		}
	}
}

