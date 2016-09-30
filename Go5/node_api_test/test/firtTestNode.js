
var chai = require('chai');
var chaiHttp = require('chai-http');

var should = chai.should();

chai.use(chaiHttp);

describe('Platform', function() {
	/*it('should list ALL platforms on /platforms GET', function(done) {
		chai.request('http://api.cd.gointegro.net')
		.get('/platforms')
		.end(function(err, res) {
			res.should.have.status(200);
			done();
		});
	});*/
	it('should list a SINGLE platform on /platforms/<id> GET', function(done) {
		chai.request('http://api.cd.gointegro.net')
		.get('/platforms?filter[subdomain]=qago65809261')
		.end(function(err, res) {
			res.should.have.status(200);
			//res.should.be.json;
			done();
		});
	});
	it('should add a SINGLE platform on /platforms POST)');
	it('should update a SINGLE platform on /platforms/<id> PATCH');
	it('should delete a SINGLE platform on /platforms/<id> DELETE');
});
